;;; Sierra Script 1.0 - (do not remove this comment)
(script# 264)
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
	lillGun 0
)
(synonyms
	(lil person girl)
)

(local
	local0
	talkCount
	local2
	temp7
)
(procedure (ReadPrint)
	(Print &rest
		#at 40 10
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(instance lillGun of Region
	
	(method (init)
		(super init:)
		(if (not (& global118 $0002))
			(LoadMany FONT 4 41)
			(LoadMany SOUND 29 94 95 96)
			(Load SCRIPT 406)
		)
		(Load VIEW 642 904)
		(LoadMany 143 243 295)
		(= global208 32)
		(= [global377 5] 295)
		(Lillian setCycle: Walk init:)
		(self setScript: reading)
	)
	
	(method (doit)
		(if (Lillian inRect: 235 102 267 118)
			(Lillian setPri: 8)
		else
			(Lillian setPri: -1)
		)
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
					
			(if (or (ClickedOnObj Lillian (event x?) (event y?)) 
					(ClickedOnObj lHead (event x?) (event y?)) 	)
					(event claimed: TRUE)
					(switch theCursor
											(602 ;necklace_
						(DoVerb {tell lillian about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell lillian about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell lillian about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell lillian about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell lillian about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell lillian about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell lillian about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell lillian about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell lillian about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell lillian about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell lillian about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell lillian about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell lillian about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell lillian about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell lillian about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell lillian about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell lillian about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell lillian about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell lillian about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell lillian about diary})						
					)
					(621 ;crank_
						(DoVerb {tell lillian about crank})						
					)
					(612 ;cane_
						(DoVerb {tell lillian about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell lillian about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell lillian about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Jules})
							)
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about blaze})
							)							
													
							
						(994 ;hear
							(DoVerb {hear lillian})
						)							
							
							
														
						(996 ;talk
							(DoVerb {converse lillian})
						)
						(998	
							(DoVerb {Examine lillian})
						)
						(995
							(= temp7
												(Print
													{Lillian}
													#button {Coger} 1
													#button {Matar} 2								
													#button {Besar} 3
													#button {Abrazar} 4
												)
											)
											(switch temp7
												(1 
													(DoVerb {get lillian})
												)
												(2 
													(DoVerb {kill lillian})
												)		
												(3 
													(DoVerb {kiss lillian})
												)		
												(4 
													(DoVerb {embrace lillian})
												)		
		
												(else
						
												(event claimed: FALSE)
												)
											)
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
			(cond 
				((Said 'converse/lil')
					(= theTalker talkLILLIAN)
					(switch talkCount
						(0
							(Say 1 264 0)
							(Say 1 264 1)
						)
						(1
							(Say 1 264 2)
						)
						(2
							(Say 1 264 3)
							(Say 1 264 4)
							(Say 1 264 5)
						)
						(3
							(Say 1 264 6)
						)
						(4
							(Say 1 264 7)
						)
						(5
							(Say 1 264 8)
						)
						(else
							(Say 1 264 9)
						)
					)
					(++ talkCount)
				)
				((Said 'hear/lil')
					(Print 264 10)
				)
			)
		)
	)
)

(instance reading of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== currentAct 3)
					(cond 
						((not global216)
							(= state -1)
						)
						((not (& global118 $0002))
;;;							(|= global118 $0002)
							(= global118 (| global118 $0020))
							(self setScript: (ScriptID 406 0))
							(= state -1)
						)
						((self script?)
							(= state -1)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(ReadPrint 264 11)
				(= seconds 7)
			)
			(2
				(cls)
				(Face Lillian ego)
				(gDoor setCycle: BegLoop)
				(= theTalker talkLILLIAN)
				(Say 1 264 12)
				(= seconds 3)
			)
			(3
				(Lillian
					setAvoider: (Avoider new:)
					setMotion: MoveTo 262 120 self
				)
			)
			(4
				(lHead setPri: 8 setScript: headActions init:)
				(Lillian
					view: 516
					illegalBits: 0
					posn: 260 118
					loop: 2
					cel: 0
					setAvoider: 0
					setScript: lilActions
				)
				(ego observeControl: cYELLOW)
				(DisposeScript AVOIDER)
				(client setScript: 0)
			)
		)
	)
)

(instance headActions of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (not local2)
					(lHead
						loop: (if (< (Random 1 100) 51) 1 else 2)
						setCycle: EndLoop
					)
				)
				(= seconds (Random 6 12))
			)
			(2
				(lHead setCycle: BegLoop)
				(= state 0)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance lilActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(Lillian loop: 0 cycleSpeed: 1 setCycle: EndLoop)
				(if (< (Random 1 100) 50)
					(= state 5)
				)
				(= seconds (Random 6 12))
			)
			(1
				(Lillian loop: 5 setCycle: Forward)
				(= seconds (Random 5 8))
			)
			(2
				(Lillian
					loop: 0
					cel: (- (NumCels Lillian) 1)
					setCycle: BegLoop
				)
				(= local2 1)
				(if (!= (lHead cel?) 0)
					(lHead setCycle: BegLoop)
				)
				(= seconds (Random 5 8))
			)
			(3
				(Lillian loop: 3 cel: 0 setCycle: EndLoop self)
			)
			(4
				(Lillian loop: 4 setCycle: Forward)
				(= seconds 2)
			)
			(5
				(Lillian
					loop: 3
					cel: (- (NumCels Lillian) 1)
					setCycle: BegLoop
				)
				(= seconds (Random 5 8))
			)
			(6
				(= local2 0)
				(Lillian loop: 6 cel: 0 setCycle: EndLoop)
				(= seconds (Random 5 8))
			)
			(7
				(Lillian setCycle: BegLoop)
				(= seconds (Random 5 8))
			)
			(8
				(= state -1)
				(= seconds (Random 5 8))
			)
		)
	)
)

(instance goSee of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= theTalker talkLILLIAN)
				(Say 1 264 13)
				(if
					(or
						(ego inRect: 64 115 107 131)
						(ego inRect: 250 115 275 127)
					)
					(ego setMotion: MoveTo (ego x?) (+ (ego y?) 20) self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face ego Lillian)
				(lHead hide:)
				(Lillian
					view: 500
					loop: 2
					setCycle: Walk
					cycleSpeed: 0
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					setMotion: MoveTo 94 123 self
				)
			)
			(2
				(gMySound setCycle: EndLoop)
				(gBdoor setCycle: EndLoop self)
				(doorFX number: 43 loop: 1 play:)
			)
			(3
				(Lillian setMotion: MoveTo 44 123 self)
			)
			(4
				(gMySound setCycle: BegLoop)
				(gBdoor setCycle: BegLoop self)
				(doorFX number: 44 loop: 1 play:)
			)
			(5
				(Print 264 14 #dispose)
				(= seconds 3)
			)
			(6
				(cls)
				(gMySound setCycle: EndLoop)
				(gBdoor setCycle: EndLoop self)
				(doorFX number: 43 loop: 1 play:)
			)
			(7
				(Lillian setMotion: MoveTo 94 123 self)
			)
			(8
				(gMySound setCycle: BegLoop)
				(gBdoor setCycle: BegLoop self)
				(doorFX number: 44 loop: 1 play:)
				(= theTalker 6)
				(Say 1 264 15)
			)
			(9
				(gMySound stopUpd:)
				(gBdoor stopUpd:)
				(Lillian setMotion: MoveTo 262 120 self)
			)
			(10
				(lHead show: setPri: 8 setScript: headActions)
				(Lillian
					view: 516
					illegalBits: 0
					posn: 260 118
					loop: 2
					cel: 0
					setAvoider: 0
					setScript: lilActions
				)
				(DisposeScript AVOIDER)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance Lillian of Actor
	(properties
		y 95
		x 128
		view 500
		loop 3
	)
	
	(method (handleEvent event)
						

		
		
		
		
		
		
		(= theTalker talkLILLIAN)
		(cond 
			(
			(and (Btst fSawDeadGuest) (Said 'tell[/lil]/gertie<about'))
				(if (& deadGuests deadGERTRUDE)
					(if (& global145 $0001)
						(Say 1 264 16)
						(event claimed: TRUE)
					else
;;;						(|= global145 $0001)
						(= global145 (| global145 $0001))
						global118						
						(self setScript: goSee)
						(event claimed: TRUE)
					)
				else
					(event claimed: FALSE)
				)
			)
			(
			(and (Btst fSawDeadGuest) (Said 'tell[/lil]/actress<about>'))
				(if (& deadGuests deadGLORIA)
					(if (& global145 $0001)
						(Say 1 264 16)
						(event claimed: TRUE)
					else
;;;						(|= global145 $0001)
						(= global145 (| global145 $0001))						
						(self setScript: goSee)
						(event claimed: TRUE)
					)
				else
					(event claimed: FALSE)
				)
			)
			((and (Btst fSawDeadGuest) (Said 'tell[/lil]/wilbur<about'))
				(if (& deadGuests deadWILBUR)
					(if (& global145 $0001)
						(Say 1 264 16)
						(event claimed: TRUE)
					else
;;;						(|= global145 $0001)
						(= global145 (| global145 $0001))						
						(self setScript: goSee)
					)
				else
					(event claimed: FALSE)
				)
			)
			((and (MousedOn self event shiftDown) (not (& global207 $0020)))
				(event claimed: TRUE)
				(DoLook {lillian})
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event shiftDown) (Said 'examine/lil'))
				)
				(event claimed: TRUE)
				(if local0
					(Print 264 17)
				else
					(Print 264 18)
				)
			)
		)
	)
)

(instance lHead of Prop
	(properties
		y 85
		x 264
		view 516
		loop 1
	)
)

(instance doorFX of Sound)
