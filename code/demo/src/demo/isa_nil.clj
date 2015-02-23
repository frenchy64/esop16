(ns demo.isa-nil
  (:refer-clojure :exclude [defn])
  (:require [clojure.core.typed :refer [defn U]]))

(defn minc [x :- (U nil Number)]
  (if (isa? (class (class x)) Class)
    (inc x)
    0))
