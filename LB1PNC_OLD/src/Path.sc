;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 983)
(include sci.sh)
(use Interface)
(use Motion)

(class Path of MoveTo
	(properties
		intermediate 0
		value 0
	)

	(method (init actor toCall inter)
		(= client actor)
		(= caller (if (>= argc 2) toCall else 0))
		(= intermediate (if (== argc 3) inter else 0))
		(= value -1)
		(= completed 0)
		(= x (client x:))
		(= y (client y:))
		(if (self atEnd:)
			(self moveDone:)
		else
			(self next:)
			(super init: client x y)
		)
	)

	(method (moveDone)
		(if (self atEnd:)
			(super moveDone:)
		else
			(if intermediate
				(intermediate cue: (/ value 2))
			)
			(self next:)
			(super init: client x y)
		)
	)

	(method (next)
		(= x (self at: (++ value)))
		(= y (self at: (++ value)))
	)

	(method (atEnd)
		(return
			(or
				(== (self at: (+ value 1)) -32768)
				(== (self at: (+ value 2)) -32768)
			)
		)
	)

	(method (at)
		(Printf 983 0 name) ; "%s needs an 'at:' method."
		(return 0)
	)
)

(class RelPath of Path
	(properties)

	(method (next)
		(+= x (self at: (++ value)))
		(+= y (self at: (++ value)))
	)
)

