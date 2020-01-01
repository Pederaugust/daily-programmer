(ns progressive-taxation.core
  (:gen-class))

(def test-data [0
                10000
                10009
                10010
                12000
                56789
                1234567])

(defn tax
  [num]
  (loop [current-tax 0
         remaining num]
    (cond (> remaining 100000) (recur
                                (+ (* 0.4 (- remaining 100000)) current-tax)
                                100000)
          (> remaining 30000) (recur
                               (+  (* 0.25 (- remaining 30000)) current-tax)
                               30000)
          (> remaining 10000) (recur
                               (+  (* 0.1 (- remaining 10000)) current-tax)
                               10000)
          :else (int (Math/floor current-tax)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (for [d test-data]
    (println "tax(" d ") => "  (tax d))))
