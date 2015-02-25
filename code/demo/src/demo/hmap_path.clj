(ns demo.hmap-path
  (:refer-clojure :exclude [fn defn])
  (:require [clojure.core.typed :refer [Num U fn HMap defalias defn Kw]] [demo.hmap :refer [mand Mand]]))

(defalias Opt
  (HMap :optional {:a (U nil Num)}))

(defn opt1 [] :- Opt, {})
(defn opt2 [] :- Opt, {:a 1})
(defn opt3 [] :- Opt, {:a nil})

(fn [m :- Opt] :- (U nil Num) (:a m))

(fn [m :- Opt] :- Num
  (if (:a m) (inc (:a m)) 0))

(defalias Comp
  (HMap :mandatory {:a Num}
        :optional {:b Kw}
        :complete? true))

(defn cmap [] :- Comp, {:a 1 :b :kw})

(fn [m :- Comp] :- Num, (:a m))
(fn [m :- Comp] :- (U nil Kw), (:b m))
(fn [m :- Comp] :- nil, (:c m))
