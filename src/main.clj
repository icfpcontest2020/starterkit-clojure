(ns main)

(defn -main [[server-url player-key]]
  (slurp (str server-url "?playerKey=" player-key)))