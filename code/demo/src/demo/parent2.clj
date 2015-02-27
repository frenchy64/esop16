(ns demo.parent2
  (:require [clojure.core.typed :refer [ann All Str U] :as t])
  (:import (java.io File)))

(ann parent ['{:file (U nil File)} -> (U nil Str)])
(defn parent [{^File f :file}]
  (if f (.getParent f) nil))
