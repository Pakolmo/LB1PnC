;;; Sierra Script 1.0 - (do not remove this comment)
(script# 402)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	wilbRead 0
)
(synonyms
	(c person fellow)
)

(local
	talkCount
	local1
	local2
	local3
)
(procedure (localproc_000c)
	(cast eachElementDo: #hide)
	(DrawPic 992 IRISIN TRUE 0)
)

(procedure (localproc_0023)
	(DrawPic 32 IRISIN TRUE 0)
	(addToPics doit:)
	(cast eachElementDo: #show)
)

(instance wilbRead of Region
	
	(method (init)
		(super init:)
		(= local3 0)
		(cond 
			((>= global154 4)
				(if (not (& global118 $0008))
					(LoadMany SOUND 29 94 95 96)
					(Load SCRIPT 406)
					(Load FONT 41)
				)
				(LoadMany VIEW 420 642 907)
				(LoadMany 143 243 247)
				(= global208 128)
				(= [global377 7] 247)
				(Wilbur posn: 196 139 init: stopUpd:)
				(self setScript: reading)
				(ego observeBlocks: WilburBlock)
			)
			((== global154 2)
				(LoadMany VIEW 400 420)
				(Wilbur view: 420 posn: 190 148 init: setScript: walkThru)
				(Clarence view: 400 init:)
			)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
				(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
						
					(if (or (ClickedOnObj Wilbur (event x?) (event y?)) 
							(ClickedInRect 138 142 196 204 event))
					
					(event claimed: TRUE)
					(switch theCursor	
					(998
						(if (not (& global207 $0080))
						(DoVerb {examine c})						
						)
						(if (& global207 $0080)
							(event claimed: TRUE)
							(Print 220 17)
						)
					)
					(996
						(DoVerb {converse wilbur})
					)
						
					
					(602 ;necklace_
						(DoVerb {tell wilbur about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell wilbur about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell wilbur about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell wilbur about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell wilbur about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell wilbur about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell wilbur about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell wilbur about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell wilbur about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell wilbur about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell wilbur about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell wilbur about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell wilbur about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell wilbur about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell wilbur about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell wilbur about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell wilbur about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell wilbur about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell wilbur about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell wilbur about diary})						
					)
					(621 ;crank_
						(DoVerb {tell wilbur about crank})						
					)
					(612 ;cane_
						(DoVerb {tell wilbur about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell wilbur about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell wilbur about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about gertie})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Jeeves})
							)											
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about blaze})
							)							
					(else
						(event claimed: FALSE)
						)																	
						)
					)		
						

		
		
			)
			)
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(super handleEvent: event)
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said '/c>')
						(cond 
							((Said 'hear')
								(Print 402 0)
							)
							((Said 'converse')
								(= theTalker talkWILBUR)
								(switch talkCount
									(0
										(Say 1 402 1)
										(= theTalker talkLAURA)
										(Say 0 402 2)
									)
									(1
										(Say 1 402 3)
										(= theTalker talkLAURA)
										(Say 0 402 4)
									)
									(2
										(Say 1 402 5)
										(= theTalker talkLAURA)
										(Say 0 402 6)
									)
									(3
										(Print 402 7)
									)
									(else
										(Print 402 8)
									)
								)
								(++ talkCount)
							)
						)
					)
					((Said '/magazine>')
						(cond 
							((Said 'read')
								(Print 402 9)
							)
							((Said 'get,rob')
								(Print 402 10)
							)
							((Said 'examine')
								(if (< (ego distanceTo: Wilbur) 40)
									(Bset fExaminedMagazine)
									(Print 402 11)
								else
									(NotClose)
								)
							)
						)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance walkThru of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global154 3)
				(= cycles 2)
			)
			(1
;;;				(HandsOff)
				(User canControl: TRUE)
				(Print 402 12 #dispose)
				(= local1 1)
				(Clarence setCycle: Walk setMotion: MoveTo 380 149)
				(Wilbur setCycle: Walk setMotion: MoveTo 360 148 self)
			)
			(2
				(cls)
				(User canInput: TRUE)
				(client setScript: 0)
			)
		)
	)
)

(instance reading of Script
	
	(method (doit)
		(if (== local3 5)
			(client setScript: 0)
		)
		(super doit:)
	)
	
	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(cond 
					((not global216)
						(= state -1)
					)
					((not (& global118 $0008))
;;;						(|= global118 $0008)
						(= global118 (| global118 $0008))
						(self setScript: (ScriptID 406 0))
						(= state -1)
					)
					((self script?)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Wilbur loop: (if local2 5 else 0) setCycle: EndLoop self)
			)
			(2
				(= rand (Random 1 100))
				(cond 
					(local2
						(cond 
							((< rand 43)
								(= state 3)
							)
							((> rand 56)
								(= state 6)
							)
							(else
								(= state 0)
							)
						)
					)
					((< rand 51)
						(= state 0)
					)
				)
				(= seconds (Random 5 10))
			)
			(3
				(= local2 1)
				(Wilbur loop: 4 cel: 0 setCycle: EndLoop)
				(= seconds (Random 5 10))
				(= state 1)
			)
			(4
				(Wilbur loop: 6 cel: 0 setCycle: EndLoop self)
			)
			(5
				(Wilbur loop: 7 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(6
				(Wilbur loop: 6 cel: 3 setCycle: BegLoop self)
				(= state 1)
			)
			(7
				(= local2 0)
				(Wilbur loop: 4 cel: 4 setCycle: EndLoop self)
				(= state 1)
			)
		)
	)
)

(instance Wilbur of Actor
	(properties
		view 424
		illegalBits $0000
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(cond 
			((and (Btst fSawDeadGuest) (Said 'tell[/c]/gertie<about'))
				(if (>= global154 4)
					(= theTalker talkWILBUR)
					(if (& deadGuests $0001)
						(cond 
							((& global145 $0004)
								(Say 1 402 13)
							)
;;;							((& (ego onControl: origin) (| cCYAN cMAGENTA))
;;;								(Print 402 14)
;;;							)
							((& (ego onControl: 1) $0028) (Print 402 14))
							(else
;;;								(HandsOff)
;;;								(|= global145 $0004)
								(= global145 (| global145 $0004))
								(Wilbur setScript: 0)
								(= local3 5)
								(wilbRead setScript: goSee)
							)
						)
					else
						(Say 1 402 15)
					)
				else
					(Print 402 16)
				)
			)
			((and (MousedOn self event shiftDown) (not (& global207 $0080)))
				(event claimed: TRUE)
				(DoLook {wilbur})
			)
			(
				(and
					(& global207 $0080)
					(or (MousedOn self event shiftDown)
						(Said 'examine/c')
					)
				)
				(event claimed: TRUE)
				(Print 402 17)
			)
		)
	)
)

(instance WilburBlock of Block
	(properties
		top 135
		left 196
		bottom 139
		right 204
	)
)

(instance Clarence of Actor
	(properties
		y 149
		x 216
		view 402
	)
)

(instance Book of Prop
	(properties
		y 116
		x 176
		view 132
		loop 1
		cel 5
		priority 11
		signal fixPriOn
	)
)

(instance Chair of Prop
	(properties
		y 139
		x 196
		view 132
		loop 1
		cel 2
	)
)

(instance goSee of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= saveDisabled TRUE)
				(Say 1 402 18)
				(Wilbur loop: 8 cel: 0 setCycle: EndLoop self)
				(if (ego inRect: 176 140 213 150)
					(ego setMotion: MoveTo 185 155)
				)
			)
			(1
				(Book init:)
				(Wilbur loop: 9 cel: 0 setCycle: EndLoop self)
			)
			(2
				(Chair init: stopUpd:)
				(Wilbur
					posn: 196 141
					view: 420
					illegalBits: cWHITE
					loop: 2
					cel: 0
					cycleSpeed: 0
					setCycle: Walk
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					setMotion: MoveTo 340 150 self
				)
				(ego loop: 0)
			)
			(3
				(= saveDisabled TRUE)
				(= seconds 5)
				(localproc_000c)
				(Chair ignoreActors: TRUE)
			)
			(4
				(localproc_0023)
				(Print 402 19 #dispose)
				(Chair startUpd:)
				(Wilbur setMotion: MoveTo 196 140 self)
				(= saveDisabled FALSE)
			)
			(5
				(cls)
				(Chair dispose:)
				(= theTalker 8)
				(Say 1 402 20)
				(Wilbur
					view: 424
					illegalBits: 0
					posn: 196 139
					loop: 9
					cel: 4
					setAvoider: 0
				)
				(if (== (ego x?) 185) (ego loop: 3))
				(= cycles 1)
			)
			(6 (Wilbur setCycle: BegLoop self))
			(7
				(DisposeScript AVOIDER)
				(Book dispose:)
				(Wilbur loop: 8 cel: 5 setCycle: BegLoop self)
			)
			(8
				(= saveDisabled FALSE)
				(= local3 0)
				(HandsOn)
				(wilbRead setScript: reading)
			)
		)
	)
)
