;;; Sierra Script 1.0 - (do not remove this comment)
(script# 45)
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room45 0
)
(synonyms
	(luggage case bag)
	(room bedroom nursery)
	(armoire armoire closet)
	(toy bear)
	(ethel person girl)
	(drawer chest dresser)
)

(local
	local0
	talkCount
	local2
)
(instance Room45 of Room
	(properties
		picture 45
	)
	
	(method (init)
		(= west 44)
		(super init:)
		(addToPics
			add:
				suit1
				bed
				lamp1
				lamp2
				wardrobe
				chest
				chair
				endtable
				bear
				dollhouse
				sofa
				shelf1
				shelf2
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				suit1
				lamp1
				lamp2
				bed
				chair
				endtable
				wardrobe
				sofa
				bear
				dollhouse
				shelf1
				shelf2
				chest
		)
		(switch currentAct
			(0
				(if (== [global368 4] 0)
					(= [global368 4] 1800)
				)
				(if (== global200 0)
					(LoadMany 143 243 221)
					(LoadMany 128 325 903)
					(= global208 8)
					(= [global377 3] 221)
					(Ethel
						ignoreActors: TRUE
						cycleSpeed: 1
						init:
						setScript: ethelActions
					)
					(eHead
						ignoreActors: TRUE
						cycleSpeed: 1
						setPri: 6
						cycleSpeed: 1
						init:
					)
					(Mouth
						ignoreActors: TRUE
						cycleSpeed: 1
						setPri: 6
						init:
						hide:
					)
				)
			)
		)
		(ego view: 0 posn: 1 124 init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 45 0)
		)
		(if (and (> (ego x?) 126) (< (ego y?) 104))
			(ego setPri: 4)
		else
			(ego setPri: -1)
		)
		(if (< (ego x?) 60)
			(= vertAngle 0)
		else
			(= vertAngle 137)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		(if (event claimed?) (return (event claimed?)))
		(return
			(if (== (event type?) saidEvent)
				(if
					(and
						global208
						(Said
							'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
						)
					)
					(self setScript: (ScriptID 243 0))
					((self script?) handleEvent: event)
					(if (event claimed?) (return TRUE))
				)
				(cond 
					((Said 'examine[<around,at][/room]')
						(Print 45 0)
					)
					((Said 'examine/blind,curtain')
						(Print 45 1)
					)
					((Said 'close,open/blind,curtain')
						(CantDo)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(if (== [global368 4] 1)
			(= global125 1)
		)
		(super newRoom: n)
	)
)

(instance ethelActions of Script
	
	(method (doit)
		(super doit:)
		(if (and (== [global368 4] 1) (== local2 0))
			(= local2 1)
			(= global203 2)
			(= state 7)
			(= seconds 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ethel cel: 0 loop: 0 setCycle: EndLoop self)
			)
			(1
				(Mouth show: setCycle: Forward)
				(= seconds 3)
			)
			(2
				(Mouth hide:)
				(Ethel setCycle: BegLoop self)
			)
			(3
				(if (< (Random 1 100) 60) (= state -1))
				(= seconds (Random 6 12))
			)
			(4
				(eHead loop: (Random 1 2) setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(5
				(eHead setCycle: BegLoop)
				(= seconds (Random 6 12))
			)
			(6
				(Ethel loop: 4 cel: 0 setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(7
				(Ethel loop: 4 cel: 0 setCycle: BegLoop)
				(= state -1)
				(= seconds (Random 6 12))
			)
			(8
				(eHead dispose:)
				(Mouth dispose:)
				(Ethel
					view: 325
					setLoop: 0
					ignoreActors: 0
					cycleSpeed: 0
					setCycle: Forward
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					setMotion: MoveTo -10 124 self
				)
			)
			(9
				(++ global200)
				(= global208 0)
				(Ethel setAvoider: 0 dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance lamp1 of RPicView
	(properties
		y 54
		x 231
		view 145
		priority 2
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of RPicView
	(properties
		y 67
		x 259
		view 145
		priority 3
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance wardrobe of RPicView
	(properties
		y 93
		x 207
		view 145
		cel 2
		priority 3
		signal ignrAct
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'move/armoire,dollhouse')
				(Print 45 2)
			)
			((Said '(examine<in),open/armoire,(door<armoire)')
				(Print 45 3)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/armoire'))
				(Print 45 4)
				(event claimed: TRUE)
			)
		)
	)
)

(instance chest of RPicView
	(properties
		y 89
		x 27
		view 145
		cel 3
		priority 5
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine[<at]/drawer')
			)
			(Print 45 5)
			(event claimed: TRUE)
		)
	)
)

(instance bed of RPicView
	(properties
		y 105
		x 125
		view 145
		cel 1
		priority 5
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {bed})
		)
	)
)

(instance chair of RPicView
	(properties
		y 101
		x 65
		view 145
		cel 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance endtable of RPicView
	(properties
		y 89
		x 87
		view 145
		cel 4
		priority 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance bear of RPicView
	(properties
		y 168
		x 291
		view 145
		cel 7
		priority 12
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/toy,animal')
				(Print 45 6)
			)
			((Said 'play')
				(Print 45 7)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/toy,animal'))
				(Print 45 8)
				(event claimed: TRUE)
			)
		)
	)
)

(instance dollhouse of RPicView
	(properties
		y 137
		x 256
		view 145
		cel 6
		priority 10
		signal ignrAct
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<in/dollhouse,(cabin<doll)')
				(Print 45 9)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/(cabin<doll),dollhouse')
				)
				(Print 45 10)
				(event claimed: TRUE)
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 167
		x 160
		view 145
		cel 9
		priority 12
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {couch})
		)
	)
)

(instance shelf1 of RPicView
	(properties
		y 167
		x 89
		view 145
		cel 10
		priority 12
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/shelf'))
			(Print 45 11)
			(event claimed: TRUE)
		)
	)
)

(instance shelf2 of RPicView
	(properties
		y 167
		x 233
		view 145
		cel 8
		priority 12
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(Print 45 11)
			(event claimed: TRUE)
		)
	)
)

(instance suit1 of RPicView
	(properties
		y 111
		x 131
		view 145
		cel 11
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/luggage')
				(Print 45 12)
			)
			((Said 'get/luggage')
				(Print 45 13)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/luggage'))
				(Print 45 14)
				(event claimed: TRUE)
			)
		)
	)
)

(instance Ethel of Actor
	(properties
		y 100
		x 68
		view 327
		illegalBits $0000
	)
	
	(method (handleEvent event)
		(return
			(cond 
				((Said 'examine<in/drink,glass')
					(Print 45 15)
				)
				((Said 'examine/drink,glass,deliver,handkerchief')
					(Print 45 16)
				)
				((Said 'get>')
					(cond 
						((Said '/drink,glass')
							(Print 45 17)
						)
						((Said '/handkerchief')
							(Print 45 18)
						)
					)
				)
				((and (MousedOn self event shiftDown) (not (& global207 $0008)))
					(event claimed: TRUE)
					(DoLook {ethel})
				)
				(
					(and
						(& global207 $0008)
						(or (MousedOn self event shiftDown) (Said 'examine/ethel'))
					)
					(event claimed: TRUE)
					(Print 45 19)
				)
				((Said 'converse/ethel')
					(= theTalker talkETHEL)
					(switch talkCount
						(0
							(Say 1 45 20)
							(= theTalker talkLAURA)
							(Say 1 45 21)
						)
						(1 (Say 1 45 22))
						(else  (Say 1 45 23))
					)
					(++ talkCount)
				)
			)
		)
	)
)

(instance eHead of Prop
	(properties
		y 64
		x 65
		view 327
		loop 1
	)
)

(instance Mouth of Prop
	(properties
		y 57
		x 66
		view 327
		loop 3
	)
)
