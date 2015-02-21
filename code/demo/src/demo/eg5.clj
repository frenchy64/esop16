(ns demo.eg5
  (:require [clojure.core.typed :as t]))

;; Multimethod identity 
(t/defalias M (t/U '{:op ':if :test M :then M :else M}
                   '{:op ':do :e1 M :e2 M}
                   '{:op ':val :val t/Any}))
(t/ann ast [M -> M])
(defmulti ast :op)
(defmethod ast :if [{:keys [test then else]}]
  {:op :if :test test :then then :else else})
(defmethod ast :do [{:keys [e1 e2]}]
  {:op :do :e1 e1 :e2 e2})
(defmethod ast :val [{:keys [val]}]
  {:op :val :val val})

(ast {:op :if 
      :test {:op :val :val 1}
      :then {:op :do 
             :e1 {:op :val :val 2} 
             :e2 {:op :val :val 3}}
      :else {:op :val :val 4}})

