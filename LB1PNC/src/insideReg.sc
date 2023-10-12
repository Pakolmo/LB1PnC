;;; Sierra Script 1.0 - (do not remove this comment)
(script# 210)
(include game.sh)
(use Main)
(use Intrface)
(use Game)

(public
	insideReg 0
)

(local
	msgID = [
		210 0
		210 1
		210 2
		210 3
		210 4
		210 5
		210 6
		210 7
		210 8
		210 9
		210 10
		210 11
		210 12
		210 13
		210 14
		210 15
		210 16
		210 17
		210 18
		210 19
		210 20
		210 21
		210 22
		210 23
		210 24
		210 25
		210 26
		210 27
		210 28
		210 0
		210 29
		210 30
		210 30
		210 30
		210 30
		210 31
		210 32
		210 33
		]
	verbSpec = [
		'examine>'
		'bang>'
		'open>'
		'close>'
		'lay,lay>'
		'go>'
		'sleep>'
		'get>'
		'break>'
		]
	nounSpec = [
		'<in/drawer'
		'[<up][/ceiling]'
		'/door'
		'[<down][/dirt]'
		'<below/carpet'
		'/carpet'
		'/wall'
		'/painting'
		'/wallpaper'
		'<(out,through)/window'
		'/window'
		'<behind/curtain'
		'/curtain'
		'<behind/blind'
		'/blind'
		'/furniture'
		'/lamp,ignite'
		'/chair'
		'<below/nightstand'
		'[<at,on]/nightstand'
		'<below/couch'
		'/couch'
		'<below/bed'
		'/luggage'
		'/bed'
		'/vase,knickknack'
		'[/*,!*][/*,!*]'
		'/window'
		'/curtain'
		'/drawer'
		'/*,!*[/*,!*]'
		'[<on,in,down][/bed[<down,on]]'
		'[<on,in,to]/bed'
		'[/*,!*][/*,!*]'
		'[<on,in,to]/bed'
		'/lamp,ignite'
		'/book'
		'/window'
		]
	local123 = [0 26 26 1 27 3 30 1 31 1 32 1 33 1 34 3 37 1]
	verbIndex
	nounIndex
	local143
)
(instance insideReg of Region
	
	(method (doit)
		(super doit:)
		(if (and (& deadGuests $0040) (== [global368 0] 2))
			(= [global368 0] 1)
			(Print 210 34)
		)
		(if (and (== currentAct 0) (Btst 39) (not (Btst 40)))
			(Print 210 35)
			(Bset 40)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(= verbIndex 0)
			(while (< verbIndex 9)
				(if (Said [verbSpec verbIndex])
					(= temp0
						(+
							[local123 (= local143 (* verbIndex 2))]
							[local123 (+ local143 1)]
						)
					)
					(= nounIndex [local123 local143])
					(while (< nounIndex temp0)
						(if (Said [nounSpec nounIndex])
							(if
								(and
									(== curRoomNum 74)
									(< (ego x?) 65)
									(!= nounIndex 1)
									(!= nounIndex 2)
									(!= nounIndex 3)
									(!= nounIndex 6)
									(!= nounIndex 16)
									(!= nounIndex 26)
									(!= nounIndex 30)
								)
								(event claimed: 0)
							else
								(= nounIndex (* nounIndex 2))
								(Print [msgID nounIndex] [msgID (++ nounIndex)])
								(break)
							)
						)
						(++ nounIndex)
					)
				)
				(++ verbIndex)
			)
		)
	)
)
