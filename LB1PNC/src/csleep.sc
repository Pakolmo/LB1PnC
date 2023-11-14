;;; Sierra Script 1.0 - (do not remove this comment)
(script# 260) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	csleep 0
)
(synonyms
	(attorney person fellow)
)

(local
	[local0 2]
)
(instance Clarence of Prop
	(properties
		y 92
		x 242
		view 413
	)
	
	(method (handleEvent event)
		(if
			(or
				(Said 'examine/attorney')
				(Said 'examine[<at]/bed')
				(MousedOn self event shiftDown)
			)
			(event claimed: TRUE)
			(Print 260 0)
		)
	)
)

(instance csleep of Region
	
	(method (init)
		(super init:)
		(= global195 64)
		(Clarence setPri: 6 cycleSpeed: 4 setCycle: Forward init:)
		(snores setPri: 6 init:)
		(LoadMany SOUND 114 115)
	)
	
	(method (doit)
		(if
			(and
				(== (snoring prevSignal?) -1)
				(== (snoring number?) 114)
			)
			(snoring number: 115 loop: 1 prevSignal: 0 play:)
		)
		(if (== (Clarence cel?) 0)
			(snoring number: 114 loop: 1 play:)
			(snores cel: 0 setCycle: EndLoop)
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
			




		
			(if (ClickedOnObj Clarence (event x?) (event y?)) 
				(event claimed: TRUE)
					(switch theCursor
						
						
					
					(602 ;necklace_
						(DoVerb {tell Clarence about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Clarence about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Clarence about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Clarence about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Clarence about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Clarence about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Clarence about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Clarence about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Clarence about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Clarence about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Clarence about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Clarence about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Clarence about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Clarence about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Clarence about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Clarence about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Clarence about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Clarence about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Clarence about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Clarence about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Clarence about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Clarence about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Clarence about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Clarence about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Jules})
							)											
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about blaze})
							)							
						
						
						
						
						(996
							(DoVerb {converse Clarence})
						)	
						(998
							(DoVerb {examine at bed})
							
						)
						(else
							(event claimed: FALSE)
						)
					)
			)
				
	

		
			)
			)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'deliver,hold/*')
						(if (and theInvItem haveInvItem)
							(Print 260 1)
						else
							(DontHave)
						)
					)
					((Said 'ask,tell//*<about')
						(Print 260 1)
					)
					((and (Said '(*,!*)>') (Said '/attorney'))
						(Print 260 1)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance snores of Prop
	(properties
		y 68
		x 228
		view 413
		loop 1
		cycleSpeed 1
	)
)

(instance snoring of Sound)
