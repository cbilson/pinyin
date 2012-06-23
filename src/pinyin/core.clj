(ns pinyin.core
  (:import [net.sourceforge.pinyin4j PinyinHelper PinyinFormatter]
           [net.sourceforge.pinyin4j.format HanyuPinyinOutputFormat
            HanyuPinyinToneType HanyuPinyinVCharType HanyuPinyinCaseType]))

(defn output-format [case-type tone-type v-char-type]
  (doto (HanyuPinyinOutputFormat.)
    (.setCaseType (case case-type
                    :upper HanyuPinyinCaseType/UPPERCASE
                    :lower HanyuPinyinCaseType/LOWERCASE))
    (.setToneType (case tone-type
                    :mark HanyuPinyinToneType/WITH_TONE_MARK
                    :number HanyuPinyinToneType/WITH_TONE_NUMBER
                    :none HanyuPinyinToneType/WITHOUT_TONE))
    (.setVCharType (case v-char-type
                     :colon HanyuPinyinVCharType/WITH_U_AND_COLON
                     :v HanyuPinyinVCharType/WITH_V
                     :unicode HanyuPinyinVCharType/WITH_U_UNICODE))))

(defn hanzi->pinyin
  ([case-type tone-type v-char-type hanzi]
     (let [of (output-format case-type tone-type v-char-type)]
       (->> hanzi
            (map #(PinyinHelper/toHanyuPinyinStringArray % of))
            (map vec))))
  ([fmt s]
     (case fmt
       :tone-numbers (hanzi->pinyin :lower :number :unicode s)))
  ([s] (hanzi->pinyin :lower :mark :unicode s)))