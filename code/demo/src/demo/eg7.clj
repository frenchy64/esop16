(ns demo.eg7
  (:refer-clojure :exclude [fn])
  (:import (clojure.lang Keyword))
  (:require [clojure.core.typed :as t :refer [defalias ann fn Assoc Num U Kw Str]]))

(defalias NK (U Num Kw))

(ann mult [NK NK -> Str])
(defmulti mult (fn [l :- NK r :- NK]
                 [(class l) (class r)]))
(defmethod mult [Keyword Keyword] [k1 k2]
  (str "Keywords " (name k1) (name k2)))
(defmethod mult [Number Keyword] [n1 k2]
  (str "NK " (inc n1) (name k2)))
(defmethod mult :default [nk1 nk2]
  (str "Default " nk1 nk2))

(mult :a 12) ;=> "Default :a12"
(mult :a :b) ;=> "Keywords ab"
(mult 42 :x) ;=> "NK 43x"
