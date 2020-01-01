(ns smooshed-morse.core
  (:gen-class)
  (:require [clojure.string :as s]))

(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))

(def morse-signs (-> (slurp "resources/morse-file.txt")
                     s/trim-newline
                     (s/split ,,, #" ")))

(def morse-chars (char-range \a \z))

(def alphabet (zipmap morse-chars morse-signs))

(defn translate-char
  [char]
  (get alphabet char))

(defn smoosh-morse
  [word]
  (map translate-char
       (seq (s/lower-case word)))) ;; sequence of letters from the string

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
