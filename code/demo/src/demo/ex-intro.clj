(ns demo.rep
  (:import (java.io File))
  (:require [clojure.core.typed :refer [ann Any U]]))

;; type annotation
(ann tostr [Any -> (U nil String)])
(defmulti tostr class) ;; multimethod declaration
;; implementation for Strings and for Files
(defmethod tostr String [x] x) 
(defmethod tostr File [x] (.getPath x))

(tostr (File. "dir/a")) ;=> "dir/a"
