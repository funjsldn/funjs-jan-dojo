(ns intro)

;; We have basic JavaScript datatypes such as numbers and strings
"Hello World"
123

;; But also more advanced structures, such as vectors, lists, maps and keywords
[1 2 3]
'(1 2 3)
{"foo" "bar"}
{:foo "bar"}

;; Clojure and ClojureScript are LISPs, so we use prefix notation
(+ 1 2)
(apply + [1 2 3])
(inc 42)
(map inc [1 2 3])

;; We can write our own functions using fn
(fn [x] (+ x 2))
((fn [x] (+ x 2))
 4)
(map (fn [x] (+ x 2)) [1 2 3])

;; This easily becomes very difficult to read, but we can def things to store them globally
(def adder (fn [x] (+ x 2)))
(map adder [1 2 3])

;; There is a shortcut for this
(defn doubler
  [x]
  (* 2 x))
(map doubler [1 2 3])

;; As you might have guessed, this is a functional language - we can't alter our maps and vector
(def m {:foo 42})
(assoc m :bar "Hello")
m

;; ... so how do we do maintain program state? Atoms!
(def a (atom 42))
a
(deref a)
@a
(swap! a inc)
(swap! a + 100)

;; But! The goal is to keep as little state around as possible!

;; A last note on JavaScript interop: we can go from ClojureScript to JavaScript datastructures
(clj->js {:foo "bar"})
(js->clj #js [1 2 3])

;; There are more examples in the TODO folder