(ns demo.eg5
  (:require [clojure.core.typed :as t :refer [ann]]
            [demo.hmap :refer [Expr]]))

(ann inc-leaf [Expr -> Expr])
(defmulti inc-leaf :op)
(defmethod inc-leaf :if [{:keys [test then else]}]
  {:op :if :test (inc-leaf test) 
   :then (inc-leaf then) :else (inc-leaf else)})
(defmethod inc-leaf :do [{:keys [left right]}]
  {:op :do :left (inc-leaf left) 
   :right (inc-leaf right)})
(defmethod inc-leaf :val [{:keys [val] :as m}]
  (assoc m :val (inc val)))

(inc-leaf {:op :if :test {:op :val :val 1}
           :then {:op :do :left {:op :val :val 2} 
                  :right {:op :val :val 3}}
           :else {:op :val :val 4}})
;=> {:op :if :test {:op :val :val 2}
;    :then {:op :do :right {:op :val :val 4} 
;           :left {:op :val :val 3}}
;    :else {:op :val :val 5}}
