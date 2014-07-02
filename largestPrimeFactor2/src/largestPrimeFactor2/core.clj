(ns largestPrimeFactor2.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))
  ; largest prime factor of a number

(defn below [number]
  ; gets list of numbers below the number
  ; only need up to sqrt number
  (range 2 (nth (math/exact-integer-sqrt number) 0)))

(defn prime? [number] (
  ; checks if number is prime
  let[
    factors (range 2 (nth (math/exact-integer-sqrt number) 0))
  ]
  (zero? (count (filter (fn[factor] (zero? (mod number factor))) factors)))))

(defn primes [numbers]
  ; gets list of primes
  (filter prime? numbers))

(defn factors [primes number]
  ; gets factors of a number
  (filter (fn[prime] (zero? (mod number prime))) primes))

(defn largest [primes] (
  ; largest factor
  last primes))

(defn -main [& arg]
  (let [
    number (read-string(nth arg 0))
    ]
    (println (largest (factors (primes (below number)) number)))
  ))