(ns demo.hmap-path
  (:refer-clojure :exclude [fn defn])
  (:require [clojure.core.typed :refer [Num U fn HMap defalias defn]] [demo.hmap :refer [mand Mand]]))

(defalias Opt
  (HMap :optional {:a (U nil Num)}))

(defn opt1 [] :- Opt, {})
(defn opt2 [] :- Opt, {:a 1})
(defn opt3 [] :- Opt, {:a nil})

(fn [m :- Opt] :- (U nil Num) (:a m))

(fn [m :- Opt] :- Num
  (if (:a m) (inc (:a m)) 0))

(defalias Comp
  (HMap :complete? true))

(defn cmap [] :- Comp, {})

(fn [m :- Comp] :- nil, (:a m))
(fn [m :- Comp] :- nil, (:b m))

(fn [] :- Mand, (merge (mand) (cmap)))
