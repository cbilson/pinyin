(ns pinyin.core-test
  (:use clojure.test
        pinyin.core))

(deftest generating-pinyin
  (is (= [["nĭ"] ["hăo" "hào"] ["ma" "mă"]]
         (hanzi->pinyin "你好嗎")))
  (is (= [["ni3"] ["hao3" "hao4"] ["ma5" "ma3"]]
         (hanzi->pinyin :tone-numbers "你好嗎")))
  (is (= [["nĭ"] ["shì"] ["yī"] ["gè" "ge"] ["hăo" "hào"] ["nǚ" "rŭ"] ["hái"]]
         (hanzi->pinyin "你是一個好女孩")))
  (is (= [["NI"] ["SHI"] ["YI"] ["GE" "GE"] ["HAO" "HAO"] ["NU:" "RU"] ["HAI"]]
         (hanzi->pinyin :upper :none :colon "你是一個好女孩"))))

