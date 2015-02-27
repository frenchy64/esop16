(ns demo.parent3
  (:refer-clojure :exclude [defn fn])
  (:require [clojure.core.typed :refer [ann All Str U fn defn] :as t])
  (:import (java.io File)))

(ann parent [(U nil File) -> (U nil Str)])
(defn parent [^File f]
  (if f (.getParent f) nil))
;; indented
  (fn [^File f :- File] (.getParent f))

(fn [^File f :- File] :- (U nil Str)
  (.getParent f))

(fn [^String s :- String] :- File
  (File. s))

(defn parent [^File f :- (U nil File)]
  (if f (.getParent f) nil))
