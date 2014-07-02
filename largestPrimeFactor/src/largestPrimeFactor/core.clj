; largest prime factor of a number
(ns largestPrimeFactor.core
  (:gen-class))

(require '[com.hypirion.primes :as p])

(defn primes [below]
  ; get primes below number
  (p/take-below below))

(defn factors [primes below]
  ; filter factors
  (filter (fn[prime] (zero? (mod below prime))) primes))

(defn largest [primes]
  ; get largest factor (last in the list)
  (last primes))

(defn -main [& arg]
  (let [below (read-string(nth arg 0))]
  (println (largest (factors (primes below) below)))))
