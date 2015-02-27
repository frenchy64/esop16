(ns demo.rep
  (:import (java.io File))
  (:require [clojure.core.typed :refer [ann Any U]]))

(ann path [Any -> (U nil String)])
(defmulti path class)
(defmethod path String [x] x)
(defmethod path File [^File x] (.getPath x))
(defmethod path nil [x] nil)

(path "dir/a") ;=> "a"
