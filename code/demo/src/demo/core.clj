(ns demo.core
  (:require [clojure.core.typed :as t]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
