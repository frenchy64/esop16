(ns demo.eg7
  (:refer-clojure :exclude [fn])
  (:import (java.io File))
  (:require [clojure.core.typed :as t :refer [defalias ann fn Assoc Num U Kw Str]]))

(defalias FS (U File String))

(ann open [FS FS -> File])
(defmulti open (fn [l r]
                 [(class l) (class r)]))
(defmethod open [File File] [f1 f2]
  (let [s (.getPath f2)]
    (do (if (string? s) nil (throw (Exception.)))
        (new File f1 s))))
(defmethod open [String String] [s1 s2]
  (new File (str s1 "/" s2)))
(defmethod open [File String] [s1 s2]
  (new File s1 s2))

(open (new File "dir") "a")      ;=> #<File dir/a>
(open "dir" "a/b")               ;=> #<File dir/a/b>
(open (new File "a/b") (new File "c")) 
                                 ;=> #<File a/b/c>
