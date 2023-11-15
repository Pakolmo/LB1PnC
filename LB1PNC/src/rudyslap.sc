;;; Sierra Script 1.0 - (do not remove this comment)
(script# 241) ;OK
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
;;;						(|= global145 $0080)
						(= global145 (| global145 $0080))
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
		
				
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
			




		
			(if (ClickedOnObj Rudy (event x?) (event y?)) 
				(event claimed: TRUE)
					(switch theCursor
						
						
					
					(602 ;necklace_
						(DoVerb {tell rudolph about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell rudolph about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell rudolph about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell rudolph about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell rudolph about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell rudolph about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell rudolph about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell rudolph about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell rudolph about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell rudolph about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell rudolph about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell rudolph about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell rudolph about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell rudolph about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell rudolph about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell rudolph about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell rudolph about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell rudolph about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell rudolph about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell rudolph about diary})						
					)
					(621 ;crank_
						(DoVerb {tell rudolph about crank})						
					)
					(612 ;cane_
						(DoVerb {tell rudolph about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell rudolph about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell rudolph about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about Jules})
							)											
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask rudolph about blaze})
							)							
						
						
						
						
						(996
							(DoVerb {converse rudolph})
						)	
						(998
							(cond
								((not (& global207 $0100))
									(event claimed: TRUE)
									(DoLook {rudy})
								)
								(
									
										(& global207 $0100))
										
									)
									(event claimed: TRUE)
									(Print 241 2)
						
						)
					
			
		
						(else
							(event claimed: FALSE)
						)
					)
			)
				
						
			(if (ClickedOnObj glass (event x?) (event y?)) 
				(event claimed: TRUE)
					(switch theCursor	
						(998			
							(DoVerb {examine glass})
						)
						(995
							(DoVerb {get glass})
						)
						(else
							(event claimed: FALSE)
						)
					)
			)
			
				
			)
			)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
