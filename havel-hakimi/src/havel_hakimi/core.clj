(ns havel-hakimi.core
  (:gen-class))


(defn remove-zeros
  " :: Seq -> Seq
  warmup1"
  [lst]
  (filter #(not= 0 %)
          lst))

(defn reverse-sort
  " :: Seq -> Seq
  warmup2"
  [lst]
  (reverse
   (sort lst)))

(defn count<len
  " :: Int -> Seq -> Boolean
  warmup3"
  [len lst]
  (< (count lst)
     len))

(defn dec-first-n
  " :: Int -> Seq -> Boolean
  warmup4"
  [n lst]
  (map-indexed (fn [indx elem]
                 (if (< indx n)
                   (dec elem)
                   elem)) lst))

(defn havel-hakimi
  " :: Seq -> Boolean
   True if no one is lying
   False if there is inconsistencies"
  [lst]
  (loop [remaining lst]
    (let [no-zeros (remove-zeros remaining)
          sorted-lst (reverse-sort no-zeros)
          n (first sorted-lst)
          nrest (rest sorted-lst)]

    (cond (empty? no-zeros) true
          (count<len n nrest) false
          :else (recur (dec-first-n n nrest))))))


(def test-lsts [[5, 3, 0, 2, 6, 2, 0, 7, 2, 5]
                [4, 2, 0, 1, 5, 0]
                [3, 1, 2, 3, 1, 0]
                [16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16]
                [14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12]
                [15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3]
                [6, 0, 10, 10, 10, 5, 8, 3, 0, 14, 16, 2, 13, 1, 2, 13, 6, 15, 5, 1]
                [2, 2, 0]
                [3, 2, 1]
                [1, 1]
                [1]
                []])

(defn -main
  [& args]
  (for [test test-lsts]
    (println "havel-hakimi(" test ") => " (havel-hakimi test))))
