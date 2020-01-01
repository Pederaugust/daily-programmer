(ns fallout-hacker.core
  (:gen-class)
  (:require [clojure.string :as s]))

(def file (slurp "resources/enable1.txt"))
(def words (s/split file #"\n"))
(def dictionary (into {} (group-by count words)))

(defn generate-word-list
  ":: Int -> Int -> Seq(String)
  n is how many words you want
  length is how long you want those words to be
  returns a list that is n long with strings of length"
  [n length]
  (let [word-of-length (get word-map length)
        size (count word-of-length)]
    (repeatedly n
                #(nth word-of-length
                      (rand-int size)))))

(defn guess-calc
  ":: String -> String -> Int
  takes two strings and letter by letter looks for equality,
  positional equality increases the score by 1
  Returns how many letters share position between the words"
  [guess answer]
  (loop [rem-guess (seq guess)
         rem-answer (seq answer)
         amount= 0]
    (cond (empty? rem-answer)
          amount=
          (= (first rem-guess) (first rem-answer))
          (recur (rest rem-guess) (rest rem-answer)
                 (inc amount=))
          :else
          (recur (rest rem-guess) (rest rem-answer)
                 amount=))))

(defn game
  []
  (let [_ (println "Difficulty? 1-5")
        difficulty (Integer/parseInt (read-line))
        length (+ 5 difficulty)
        word-list (generate-word-list length 5)
        answer (nth word-list (rand-int (count word-list)))]
    (println word-list answer)
    (loop [amount-guesses 4]
      (if (= amount-guesses 0)
        (println "You loose... Correct answer was " answer)
          (let [_ (println "Guess (" amount-guesses " left)?")
                guess (read-line)
                _ (println guess)
                score (guess-calc guess answer)]
            (if (= score (dec length))
              (println "You win!")
              (do
                (println score "/" length " correct")
                (recur (dec amount-guesses)))))))))

(defn -main
  [& args]
  )
