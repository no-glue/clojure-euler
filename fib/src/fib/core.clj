;; fibonacci sequence
(ns fib.core
  (:gen-class))

(defn fibStep [[a b]]
  [b (+ a b)])

(defn fibSeq []
  ;; iterate, gets sequence x, f(x), f(f(x))...
  ;; map first takes first element from each pair
  (map first (iterate fibStep [0 1])))

(defn -main[& arg]
  (println(take (read-string(nth arg 0)) (fibSeq))))