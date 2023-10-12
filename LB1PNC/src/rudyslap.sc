;;; Sierra Script 1.0 - (do not remove this comment)
(script# 241)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rudyslap 0
)
(synonyms
	(drink alcohol)
	(rudolph person fellow)
)

(local
	talkCount
)
(procedure (localproc_000c)
	(cast eachElementDo: #hide)
	(DrawPic 992 IRISIN TRUE 0)
)

(procedure (localproc_0023)
	(DrawPic 48 IRISOUT TRUE 0)
	(addToPics doit:)
	(cast eachElementDo: #show)
)

(instance Rudy of Actor
	
	(method (handleEvent event)
		(cond 
			((and (Btst fSawDeadGuest) (Said 'tell[/rudolph]/gertie<about'))
				(= theTalker talkRUDY)
				(if (& deadGuests deadGERTRUDE)
					(if (& global145 $0080)
						(Say 1 241 0)
					else
						(Say 1 241 1)
						(|= global145 $0080)
						(Rudy setScript: goSee)
					)
				else
					(event claimed: FALSE)
				)
			)
			((and (MousedOn self event shiftDown) (not (& global207 $0100)))
				(event claimed: TRUE)
				(DoLook {rudy})
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event shiftDown) (Said 'examine/rudolph'))
				)
				(event claimed: TRUE)
				(Print 241 2)
			)
		)
	)
)

(instance myMusic of Sound)

(instance rudyslap of Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(Load SOUND 112)
		(Load SCRIPT AVOIDER)
		(LoadMany 143 243 252)
		(LoadMany VIEW 380 381 460 908)
		(= global208 256)
		(= [global377 8] 252)
		(glass setPri: 11 init: stopUpd:)
		(if (== global126 0)
			(Rudy view: 387 loop: 0 posn: 151 113 init:)
			(Fifi init: ignoreActors: TRUE)
			(self setScript: slapHim)
		else
			(Rudy init: setScript: drink)
		)
		(myMusic number: 112 loop: 0)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(if (event claimed?)
			(return (event claimed?))
		)
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'examine/glass,drink')
						(Print 241 3)
					)
					((Said 'hear/rudolph')
						(Print 241 4)
					)
					((or (Said 'get/drink,glass') (Said 'drink/drink'))
						(Print 241 5)
					)
					((Said 'converse/rudolph')
						(= theTalker talkRUDY)
						(switch talkCount
							(0
								(Say 1 241 6)
							)
							(1
								(Say 1 241 7)
							)
							(2
								(Say 1 241 8)
								(= theTalker talkLAURA)
								(Say 0 241 9)
							)
							(3
								(Say 1 241 10)
								(= theTalker talkLAURA)
								(Say 0 241 11)
							)
							(4
								(Say 1 241 12)
							)
							(else
								(Print 241 13)
							)
						)
						(++ talkCount)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance slapHim of Script

	(method (doit)
		(super doit:)
		(if (== (Fifi x?) -10) (Fifi dispose:))
		(if (and (== state 2) (== (Fifi cel?) 4))
			(myMusic number: 112 loop: 1 priority: 5 play:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global126 1)
				(Rudy cycleSpeed: 1 loop: 0 setCycle: EndLoop self)
			)
			(1
				(Rudy hide:)
				(Fifi posn: 114 113 cel: 0 loop: 2 setCycle: Forward)
				(= seconds 3)
			)
			(2
				(Fifi loop: 0 cycleSpeed: 1 setCycle: EndLoop self)
				(Print 241 14
					#at 90 20
					#font 4
					#dispose
				)
			)
			(3
				(Rudy
					show:
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: EndLoop self
				)
				(Fifi loop: 1 posn: 114 113 cycleSpeed: 1 setCycle: EndLoop)
			)
			(4
				(cls)
				(Rudy loop: 2 cycleSpeed: 0 setCycle: Forward)
				(= seconds 4)
			)
			(5
				(Rudy setCycle: 0)
				(Fifi
					view: 460
					cycleSpeed: 0
					setPri: -1
					setAvoider: (Avoider new:)
					setCycle: Walk
					ignoreActors: 0
					setMotion: MoveTo -10 101 self
				)
			)
			(6
				(cls)
				(Rudy
					view: 380
					setCycle: Walk
					setAvoider: (Avoider new:)
					setMotion: MoveTo 164 145 self
				)
			)
			(7
				(Rudy setScript: drink)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance drink of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Rudy
					view: 381
					cycleSpeed: 2
					loop: 3
					cel: 2
					posn: 169 126
					setPri: 11
					illegalBits: 0
					ignoreActors: TRUE
					setCycle: BegLoop self
				)
			)
			(1
				(glass hide:)
				(Rudy loop: 2 cel: 3 setCycle: BegLoop self)
			)
			(2
				(Rudy loop: 1 cel: 0 setCycle: EndLoop)
				(= seconds 3)
			)
			(3
				(Rudy setCycle: BegLoop self)
			)
			(4
				(Rudy loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(5
				(glass show:)
				(Rudy loop: 3 cel: 0 setCycle: EndLoop)
				(if (> (Random 1 100) 40)
					(= state -1)
				)
				(= seconds (Random 6 12))
			)
			(6
				(Rudy loop: 5 cel: 0 setCycle: EndLoop)
				(if (< (Random 1 100) 50)
					(= state 8)
				)
				(= seconds (Random 3 6))
			)
			(7
				(Rudy loop: 6 cel: 0 setCycle: EndLoop)
				(= seconds (Random 3 6))
			)
			(8
				(Rudy loop: 6 cel: 2 setCycle: BegLoop self)
			)
			(9
				(Rudy cel: 3 loop: 5 setCycle: BegLoop self)
			)
			(10
				(if (< (Random 1 100) 50)
					(= state -1)
				)
				(= seconds (Random 3 9))
			)
			(11
				(Rudy loop: 4 setCycle: EndLoop)
				(if (< (Random 1 100) 50)
					(= state 13)
				)
				(= seconds (Random 3 9))
			)
			(12
				(Rudy loop: 9 setCycle: EndLoop)
				(= seconds (Random 3 9))
			)
			(13
				(Rudy cel: 3 setCycle: BegLoop)
				(= seconds (Random 3 9))
			)
			(14
				(Rudy loop: 4 cel: 3 setCycle: BegLoop)
				(= seconds (Random 3 9))
				(= state -1)
			)
		)
	)
)

(instance goSee of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== (Rudy loop?) 2) (== (Rudy loop?) 1))
					(Rudy loop: 2 cel: 0 setCycle: EndLoop self)
				else
					(= cycles 1)
				)
				(if (ego inRect: 160 138 170 146)
					(ego setMotion: MoveTo (ego x?) (- (ego y?) 10))
				)
			)
			(1
				(glass show:)
				(cls)
				(HandsOff)
				(Rudy
					view: 380
					posn: 164 145
					setCycle: Walk
					cycleSpeed: 0
					setPri: -1
					illegalBits: cWHITE
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					setMotion: MoveTo 69 109 self
				)
				(if (ego inRect: 67 107 71 111)
					(ego setMotion: MoveTo (ego x?) (- (ego y?) 10))
				)
			)
			(2
				(Rudy setMotion: MoveTo -20 96 self)
			)
			(3
				(= saveDisabled TRUE)
				(localproc_000c)
				(= seconds 5)
			)
			(4
				(localproc_0023)
				(Print 241 15 #dispose)
				(Rudy setMotion: MoveTo 164 145 self)
				(= saveDisabled 0)
			)
			(5
				(Face ego Rudy)
				(cls)
				(= theTalker talkRUDY)
				(Say 1 241 16)
				(HandsOn)
				(Rudy setAvoider: 0)
				(Rudy setScript: drink)
			)
		)
	)
)

(instance glass of Prop
	(properties
		y 138
		x 151
		view 381
		cel 2
	)
)

(instance Fifi of Actor
	(properties
		y 113
		x 121
		view 467
		loop 1
		cel 2
	)
)
