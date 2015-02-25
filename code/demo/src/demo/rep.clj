(ns demo.rep
  (:import (clojure.lang Keyword))
  (:require [clojure.core.typed :refer [ann Str Any]]))

(ann rep [Any -> Str])
(defmulti rep class)
(defmethod rep Keyword [x] (str (name x)))
(defmethod rep Number [x] (str (inc x)))

(rep :a) ;=> "a"
(rep 1)  ;=> "2"
