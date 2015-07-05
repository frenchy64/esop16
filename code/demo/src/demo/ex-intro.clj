(ns ^:core.typed demo.eg-intro
  (:import (java.io File))
  (:require [clojure.core.typed :refer [ann Any U Str defalias]]))

; a function annotation. 
; Input: non-nil (null) File or String, via union
; Ouput: nilable String
(ann pname [(U File String) -> (U nil String)])
(defmulti pname class) ; multimethod on arg's class
(defmethod pname String [s] ; String implementation
  (pname (new File s))) ; JVM constructors non-nil
(defmethod pname File [f] ; File implementation
  (.getName f)) ; JVM method target `f` must be 
                ; non-nil, but return is nilable
(pname "lschemer/STAINS/JELLY") ; :- (U nil Str)
;=> "JELLY"
