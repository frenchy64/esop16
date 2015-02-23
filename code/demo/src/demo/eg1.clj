(ns demo.eg1
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [fn U Num]]))

(fn [x :- (U nil Num)]
  (when (number? x)
    (inc x)))
