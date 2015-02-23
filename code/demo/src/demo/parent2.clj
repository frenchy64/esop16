(ns demo.parent2
  (:require [clojure.core.typed :refer [ann All Str U] :as t])
  (:import (java.io File)))

(ann parent ['{:file (U nil File)} -> (U nil Str)])
(defn parent [{:keys [^File file] :as m}]
  (when (:file m)
    (.getParent file)))
