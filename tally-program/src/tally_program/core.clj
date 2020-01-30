(ns tally-program.core
  (:gen-class)
  (:require [clojure.string :as s]))


(def challenge-data "EbAAdbBEaBaaBBdAccbeebaec")

(defn make-board
  ":: String -> Map(Char Int)"
  [data]
  (->> (char-array data)
       seq
       (map #(Character/toLowerCase %) ,,,)
       (into (set) ,,,)
       (map (fn [element]
              (vector element 0)) ,,,)
       (into {} ,,,)))

(defn inc-score [board character]
  (assoc board character
         (inc (get board character))))

(defn dec-score [board character]
  (assoc board character
         (dec (get board character))))

(defn tally-scores
  [data]
  (loop [remaining (seq (char-array data))
         board (make-board data)]
    (let [character (first remaining)]

      (cond (empty? remaining) board

          (Character/isLowerCase (first remaining))
          (recur (rest remaining) (inc-score board character))

          (Character/isUpperCase (first remaining))
          (recur (rest remaining) (dec-score board (Character/toLowerCase
                                                    character)))))))




(defn -main
  [& args]
  (println "Hello, World!"))
