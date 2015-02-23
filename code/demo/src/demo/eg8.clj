(ns demo.eg8
  (:refer-clojure :exclude [fn])
  (:import (java.io File))
  (:require [clojure.core.typed :as t :refer [defalias ann fn Assoc Num U Kw Str]]))

(defalias PayLoad
  (U '{:p ':F :file (U nil File)}
     '{:p ':S :str (U nil Str)}))

(ann process [PayLoad -> (U nil Str)])
(defmulti process :p)
(defmethod process :F [{:keys [^File file]}]
  (when file
    (.getParent file)))
(defmethod process :S [{:keys [^String str]}]
  (assert str "Must provide string")
  (.toUpperCase str))

(process {:p :S :str "a"}) ;=> "a"
(process {:p :F :file (File. "dir/a")}) ;=> "dir"
