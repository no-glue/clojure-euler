;; sum of even fibonacci terms below 4000000
(ns fibSum.core
  (:gen-class))

(defn fibStep [[a b]]
  [b (+ a b)])

(defn fibSeq []
  ;; ...iterate... gets sequence (builds a list) listed, f(listed), f(f(listed))...
  ;; ...map first... takes first element from each pair
  (map first (iterate fibStep [0 1])))

(defn even [sequence]
  (filter (fn[listed](and (zero? (mod listed 2)) (< listed 4000000))) sequence))

(defn sum [sequence]
  (reduce + sequence))

(defn -main []
  (println (sum(even(take 40 (fibSeq))))))