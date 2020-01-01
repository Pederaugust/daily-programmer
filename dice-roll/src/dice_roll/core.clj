(ns dice-roll.core
  (:gen-class)
  (:require [clojure.string :as s]))

(def test-data
  "5d12
6d4
1d2
1d8
3d6
4d20
100d100")

(defn parse-data
  [data]
  (->> (s/split data #"\n")
       (map #(s/split % #"d") ,,,)
       (map (fn [pair]
              (map #(Integer/parseInt %) pair)) ,,,)))

(defn calc-rolls
  [dice sides]
  (reduce +
          (repeatedly dice
                      #(rand-int (inc sides)))))

(defn calculate-data
  [input]
  (map #(calc-rolls (first %)
                    (last %))
       input))


(defn -main
  [& args]
  (println "Dice Roll!"))
