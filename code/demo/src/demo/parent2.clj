(ns demo.parent2
  (:require [clojure.core.typed :refer [ann All Str U defalias] :as t])
  (:import (java.io File)))

(defalias MFile (U nil File))
(defalias MStr (U nil Str))
(defn parent 
  [{f :file} :- '{:file MFile}] :- MStr
  (if f (.getParent f) nil))
