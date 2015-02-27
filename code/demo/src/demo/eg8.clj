(ns demo.eg8
  (:refer-clojure :exclude [fn])
  (:import (java.io File))
  (:require [clojure.core.typed :as t :refer [defalias ann fn Assoc Num U Kw Str]]))

(defalias FSM
  (U '{:p ':F :file (U nil File)}
     '{:p ':S :str (U nil String)}))

(ann maybe-parent [FSM -> (U nil Str)])
(defmulti maybe-parent :p)
(defmethod maybe-parent :F [{file :file :as m}]
  (if (:file m) (.getParent ^File file) nil))
(defmethod maybe-parent :S [{^String str :str}]
  (do (if str nil (throw (Exception.)))
      (.getParent (File. str))))

(maybe-parent {:p :S :str "dir/a"}) ;=> "dir"
(maybe-parent {:p :F :file (File. "dir/a")});=> "dir"
(maybe-parent {:p :F :file nil}) ;=> nil
