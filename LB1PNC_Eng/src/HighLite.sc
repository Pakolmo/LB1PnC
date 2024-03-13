;;;;;; Sierra Script 1.0 - (do not remove this comment)
;;;(script# 214)
;;;(include game.sh)
;;;(use Main)
;;;(use Motion)
;;;(use Actor)
;;;
;;;
;;;(class HighLite of Prop
;;;	(properties
;;;		highLiteX 0
;;;		highLiteY 0
;;;		deltaX 0
;;;		deltaY 0
;;;		leadingEdge 0
;;;		ignoreCast 0
;;;		eyesID 0
;;;	)
;;;	
;;;	(method (init)
;;;		(super init:)
;;;		(self HighLitePosn:)
;;;		(self
;;;			view: 151
;;;			loop: 1
;;;			cel: 0
;;;			setPri: 2
;;;			posn: highLiteX highLiteY
;;;			ignoreActors: TRUE
;;;			setCycle: Forward
;;;		)
;;;		(self
;;;			leadingEdge: (/ (+ (- (self brRight?) (self brLeft?)) 1) 2)
;;;		)
;;;	)
;;;	
;;;	(method (doit &tmp node nextNode obj theX theCel numCels)
;;;		(self HighLitePosn:)
;;;		(self posn: highLiteX highLiteY)
;;;		(if (not ignoreCast)
;;;			(= node (cast first:))
;;;			(while node
;;;				(= nextNode (cast next: node))
;;;				(if
;;;					(and
;;;						(IsObject (= obj (NodeValue node)))
;;;						(!= obj ego)
;;;						(!= obj self)
;;;						(!= obj eyesID)
;;;					)
;;;					(= theX (- (obj x?) (self x?)))
;;;					(if (>= leadingEdge (Abs theX))
;;;						(= numCels (NumCels obj))
;;;						(if
;;;							(<
;;;								(= theCel
;;;									(+
;;;										(/
;;;											(* (+ (/ (* theX 1000) leadingEdge) 5) (/ numCels 2))
;;;											1000
;;;										)
;;;										(/ numCels 2)
;;;									)
;;;								)
;;;								numCels
;;;							)
;;;							(obj show: cel: theCel forceUpd:)
;;;						)
;;;					else
;;;						(obj hide:)
;;;					)
;;;				)
;;;				(= node nextNode)
;;;			)
;;;		)
;;;		(super doit:)
;;;	)
;;;	
;;;	(method (handleEvent event)
;;;		(if (event claimed?) (return))
;;;	)
;;;	
;;;	(method (HighLitePosn &tmp egoLoop)
;;;		(if (or (== (= egoLoop (ego loop?)) 2) (== egoLoop 1))
;;;			(= highLiteX (- (ego x?) deltaX))
;;;		else
;;;			(= highLiteX (+ (ego x?) deltaX))
;;;		)
;;;		(= highLiteY (- (ego y?) deltaY))
;;;	)
;;;)
;;;

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 214)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)


(class HighLite of Prop
	(properties
		y 0
		x 0
		z 0
		heading 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		cycleSpeed 0
		script 0
		cycler 0
		timer 0
		highLiteX 0
		highLiteY 0
		deltaX 0
		deltaY 0
		leadingEdge 0
		ignoreCast 0
		eyesID 0
	)
	
	(method (init)
		(super init:)
		(self HighLitePosn:)
		(self
			view: 151
			loop: 1
			cel: 0
			setPri: 2
			posn: highLiteX highLiteY
			ignoreActors: 1
			setCycle: Forward
		)
		(self
			leadingEdge: (/ (+ (- (self brRight?) (self brLeft?)) 1) 2)
		)
	)
	
	(method (doit &tmp gCastFirst theGCastFirst temp2 temp3 temp4 temp5)
		(self HighLitePosn:)
		(self posn: highLiteX highLiteY)
		(if (not ignoreCast)
			(= gCastFirst (cast first:))
			(while gCastFirst
				(= theGCastFirst (cast next: gCastFirst))
				(if
					(and
						(IsObject (= temp2 (NodeValue gCastFirst)))
						(!= temp2 ego)
						(!= temp2 self)
						(!= temp2 eyesID)
					)
					(= temp3 (- (temp2 x?) (self x?)))
					(if (>= leadingEdge (Abs temp3))
						(= temp5 (NumCels temp2))
						(if
							(<
								(= temp4
									(+
										(/
											(* (+ (/ (* temp3 1000) leadingEdge) 5) (/ temp5 2))
											1000
										)
										(/ temp5 2)
									)
								)
								temp5
							)
							(temp2 show: cel: temp4 forceUpd:)
						)
					else
						(temp2 hide:)
					)
				)
				(= gCastFirst theGCastFirst)
			)
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
	)
	
	(method (HighLitePosn &tmp gEgoLoop)
		(if
		(or (== (= gEgoLoop (ego loop?)) 2) (== gEgoLoop 1))
			(= highLiteX (- (ego x?) deltaX))
		else
			(= highLiteX (+ (ego x?) deltaX))
		)
		(= highLiteY (- (ego y?) deltaY))
	)
)
