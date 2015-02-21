(ns demo.eg1
  (:require [clojure.core.typed :as t]))

;; Occurrence typing
(t/fn [x :- (t/U nil t/Num)]
  (when (number? x)
    (inc x)))
