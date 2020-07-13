(ns main
  (:require 
   [org.httpkit.client :as http]))

(defn -main [server-url player-key]
  (let [resp @(http/get server-url {:query-params {:playerKey "player-key"}})
        {:keys [status headers body error]} resp]
    (if error
      (println "Unexpected server response:\nHTTP code:" status "\nResponse body:" body)
      (println "Server response:" body))))