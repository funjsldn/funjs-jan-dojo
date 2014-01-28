(ns dojo.client)

;; allows us to do print and println
(enable-console-print!)


(println "Hello world")


;; we create an atom for holding our items
(def todos
  (atom [["Learn ClojureScript" true]]))

(println "TODOs before swap")
;; please notice the "@" - that's how we get the content
(println (pr-str @todos))

;; conj conjoins an element to a list
(swap! todos conj ["Drink beer" false])

(println "TODOs after swap")
(println (pr-str @todos))

;; map that works.
(defn so-very-map-wow
  [f list]
  (loop [i 0]
    (when (< i (count list))
      (f (list i))
      (recur (inc i))
    )
  )
)

(defn add-todo
  [item]
  (swap! todos conj [item, false]))

(defn get-innerText
  [element]
  (.-innerText element))

(defn get-value
  [element]
  (.-value element))

;; here we grab the list and add an alement
(defn render-list-item
  [todo]
  (let [list (.getElementById js/document "list")
        new-bullet (.createElement js/document "li")]
    (set! (.-innerText new-bullet) (nth todo 0))
    (.appendChild list new-bullet))
)

(defn render-list
  [todos]
  (so-very-map-wow render-list-item todos)
)

(defn clear-element
  [element]
  (set! (.-innerHTML element) "")
)

(defn clear-input-element
  [input]
  (set! (.-value input) "")
)

; (.log js/console "AAAA")
; (map (fn [c] (.log js/console c)) "BBBBB")
(map render-list-item ["foo" "bar"])

(defn rerender
  [todos] ; list of items
  (clear-element (.getElementById js/document "list"))
  (render-list todos)
)

(defn find-item
  [todo-text]
  (filter (fn [item]
      (= (nth item 0) todo-text)
  ) @todos)
)

(rerender @todos)

;; here we grap the add-button object and register a listener
(let [add-button (.getElementById js/document "add")]
  (.log js/console add-button)
  (.addEventListener add-button
                     "click"
                     (fn [e]
                        (let [todo-text (get-value (.getElementById js/document "input-field"))]
                         (add-todo todo-text)
                         (clear-input-element (.getElementById js/document "input-field"))
                         ; QQ: todos VS @todos
                         )
                         (rerender @todos)
                        
                       ;(println "click")

                       ;; uncomment the line below to add a breakpoint
                       ;; (js* "debugger;")

                       ;; alternatively, here is some old-school debugging
                       ;(.log js/console e)
                       ;(.log js/console (.-target e)))
                     ))
  )

(let [list-container (.getElementById js/document "list")]
  (.log js/console list-container)
  (.addEventListener list-container
                     "click"
                     (fn [e]
                      (println (.-target e))
                      (println (find-item (get-innerText (.-target e))))
                      (println (nth (find-item (get-innerText (.-target e))) 1))
                     ))
  )





;; so, here's what needs to be implemented:
;; - add whatever is in the input box to our todos atom list
;; - update the html list to have exactly what is in the todos atom
;; - allow us to tick things off the list
;; - styling


;; and, if you're super ambitious:
;; - explore AngularJS integration for maintaining consistency between the atom an the dom list (http://keminglabs.com/blog/angular-cljs-weather-app/)
;; - explore React for a similar binding http://swannodette.github.io/2013/12/17/the-future-of-javascript-mvcs/
;; - play with FRP in ClojureScript using Flapjax https://github.com/alandipert/flapjax-demo
