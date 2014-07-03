(ns collatz.core
  (:gen-class))
  ; longest collatz sequence 

(defn rule [number]
  ; rule to generate term
  ; prev nxt in the sequence
  (if (zero? (mod number 2)) (/ number 2.0) (+ (* 3 number) 1)))

(defn collatz-sequence [number]
  ; collatz sequence of a number
  (count (distinct (take 1000 (iterate rule number)))))

(defn length [ceiling]
  ; length of sequences below ceiling
  (for[
    x (range 1 ceiling)
    ][(collatz-sequence x) x]))

(defn sort-length [sequence]
  ; sort length 
  (sort-by first > sequence))

(defn -main [& arg]
  (println (let[ceiling (read-string (nth arg 0))] (first (sort-length (length ceiling))))))