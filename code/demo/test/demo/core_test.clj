(ns demo.core-test
  (:require [clojure.test :refer :all]
            [clojure.core.typed :as t :refer [check-ns]]
            [demo.core :refer :all]))

(defn bad-check-ns? [ns]
  (boolean
    (seq (:delayed-errors 
           (t/check-ns-info 'demo.eg4)))))

(deftest type-examples
  (testing "simple occurrence typing"
    (is (check-ns 'demo.eg1)))
  (testing "simple let-aliasing"
    (is (check-ns 'demo.eg2)))
  (testing "let-aliasing with paths"
    (is (check-ns 'demo.eg3)))
  (testing "bad merge"
    (is (bad-check-ns? 'demo.eg4)))
  (testing "HMap multimethod"
    (is (check-ns 'demo.eg5)))
  (testing "HVec multimethod"
    (is (check-ns 'demo.eg6)))
  (testing "double dispatch multimethod"
    (is (check-ns 'demo.eg7)))
  (testing "file parent"
    (is (check-ns 'demo.parent)))
  (testing "file parent with aliasing"
    (is (check-ns 'demo.parent2)))
  )
