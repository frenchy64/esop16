(ns demo.hmap
  (:refer-clojure :exclude [fn defn])
  (:require [clojure.core.typed :refer [defalias Num U fn ann-form defn Kw]]))

(defalias Expr
  (U '{:op ':if :test Expr :then Expr :else Expr}
     '{:op ':do :left Expr :right Expr}
     '{:op ':val :val Num}))

(defn expr1 [n :- Num] :- Expr
  (let [v  {:op :val :val n}
        tmp {:op :do :left v}]
    {:op :if
     :test (assoc (dissoc tmp :left)
                  :op :val :val (inc n))
     :then (assoc tmp :right (assoc v :val 3))
     :else (merge v {:val (inc (:val v))})}))

(expr1 1)
;=> {:op :if
;    :test {:op :val :val 2}
;    :then {:op :do :right {:val 3 :op :val}
;           :left {:op :val :val 1}}
;    :else {:op :val :val 2}}

(defn an-exp [] :- Expr
  (let [v {:op :val :val 1}]
    {:op :do :left v :right v}))

(fn [{:keys [op]} :- Expr] :- Kw
  op)

(fn [{:keys [a b]} 
     :- (U (HMap :mandatory {:a Num} :absent-keys #{:b})
           (HMap :mandatory {:b Num} :absent-keys #{:a}))]
  (when (and a b)
    (+ a b)))

(fn [{:keys [a b]} 
     :- (U (HMap :mandatory {:a Num} :complete? true)
           (HMap :mandatory {:b Num} :complete? true))]
  (when (and a b)
    (+ a b)))

#_
(fn [{:keys [a b]} :- (U '{:a Num} '{:b Num})]
  (when (and a b)
    (+ a b)))
;; Static method clojure.lang.Numbers/add could not be applied to arguments:
;; 
;; Domains:
;; 	Num Num
;; 
;; Arguments:
;; 	Any Any
