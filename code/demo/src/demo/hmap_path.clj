(ns demo.hmap-path
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [Num U fn HMap defalias]]))

(defalias OptM
  (HMap :optional {:a (U nil Num)}))

(fn [m :- OptM]
  (if (:a m) (inc (:a m)) 0))
