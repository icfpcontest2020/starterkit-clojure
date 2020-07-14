(ns main
  (:require 
   [org.httpkit.client :as http]))

(defn -main [server-url player-key]
  (let [resp @(http/request {:method :post :url server-url :body player-key})
        {:keys [status headers body error]} resp]
    (if error
      (do (println "Unexpected server response:\n" error) (System/exit 1))
      (if (== status 200)
        (println "Server response:" body)
        (do (println "Unexpected server response:\nHTTP code:" status "\nResponse body:" body) (System/exit 2))))))
