;; sum of multiples of 3 and 5 below 1000
(ns multiplesSum.core
  (:gen-class))

(defn sum []
  (reduce + (for[x (range 1 1000)
    :when (or (zero? (mod x 3)) (zero? (mod x 5)))]x)))

(defn -main[&arg]
  (println (sum)))