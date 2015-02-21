(ns demo.core
  (:require [clojure.core.typed :as t]))

;; Simple let-aliasing
(t/fn [x :- (t/U nil t/Num)]
  (let [x1 x]
    (when (number? x)
      (inc x1))))

;; let-aliasing with paths
(t/fn [{x :a :as m} :- '{:a (t/U nil t/Num)}]
  (let [x1 x]
    (when (number? (:a m))
      (inc x1))))

;; HMap merging
(t/fn [m1 :- '{:a t/Num}
       m2 :- '{:b t/Num}]
  :- '{:a t/Num :b t/Num}
  (merge m1 m2))

;; HMap merging
((t/fn [m1 :- '{:a t/Num}
        m2 :- '{:b t/Num}]
   :- '{:a t/Num :b t/Num}
   (merge m1 m2))
 {:a 1}
 {:a nil :b 2})
