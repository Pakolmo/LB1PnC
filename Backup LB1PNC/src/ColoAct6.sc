;;; Sierra Script 1.0 - (do not remove this comment)
(script# 374) ;OK
(include game.sh)
(use Main)
(use atsgl)
(use Intrface)
(use System)

(public
	ColoAct6 0
)

(local
	local0
	local1 = [374 0 374 1 374 2 374 3 374 4 374 5 374 6 374 7 374 8 374 9 374 10 374 11 374 12 374 13 374 14 374 15 374 16 374 17 374 18 374 19 374 20 374 21 374 22 374 23 374 24 374 25 374 26 374 27 374 28 374 29 374 30 374 31 374 32 374 33 374 34 374 35 374 36 374 37 374 38 374 39 374 40 374 41 374 42 374 43 374 44 374 45 374 46 374 47 374 48 374 49 374 50 374 51 374 52 374 53 374 54 374 55 374 56 374 57 374 58 374 59 374 60 374 61 374 62 374 63 374 64 374 65 374 66 374 67 374 68 374 69 374 70 374 71 374 72 374 73 374 74 374 75 374 76 374 77 374 78 374 79 374 80 374 81 374 82 374 83 374 84 374 85 374 86 374 87 374 88 374 89 374 90 374 91 374 92 374 93 374 94 374 95 374 96 374 97 374 98 374 99]
	local201 = [8256 10240 8320 16386 8196 2 9216 64 65 68 192 320 8 16 1 4 1024 1040 32 34 40 12288 256 0 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 16386 8196 2 0 9216 64 65 68 192 320 8 16 1 4 1024 1040 32 34 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 16386 8196 9216 12288 8208 8194 16392 16386 8196 9216 12288 8208 8194 16392 512 512 512 512 512 512 -1]
	local296 = [0 37 74 81 88]
	local301 =  89
	local302 = [90 91 92 93 94]
)
(instance ColoAct6 of Script
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 374)
	)
	
	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond 
			((event claimed?))
			((and (== (event type?) saidEvent) global212)
				(= local0 -1)
				(= temp2 [local296 (- global212 1)])
				(while (< temp2 [local296 global212])
					(if (== global211 [local201 temp2])
						(= local0 temp2)
						(break)
					)
					(++ temp2)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond 
						((and (== local0 52) (& deadGuests $0001)) (= temp3 94))
						((and (== local0 65) (& deadGuests $0002)) (= temp3 95))
						((and (== local0 53) (& deadGuests $0004)) (= temp3 96))
						((and (== local0 50) (& deadGuests $0008)) (= temp3 97))
						(
							(and
								(or (== local0 51) (== local0 54))
								(& deadGuests $0010)
							)
							(if (== local0 51) (= temp3 98) else (= temp3 99))
						)
						(else (= temp3 0))
					)
					(if temp3
						(= [local1 temp1] [local1 (= temp3 (* temp3 2))])
						(= [local1 (+ temp1 1)] [local1 (++ temp3)])
					)
					(cond 
						((>= local0 local301)
							(global209 claimed: 1)
							(Print [local1 temp1] [local1 (++ temp1)])
						)
						(
							(and
								(not
									(proc243_1 local0 [local1 temp1] [local1 (++ temp1)])
								)
								(== [local201 (++ temp2)] 0)
							)
							(DaddySays [local1 (++ temp1)] [local1 (++ temp1)])
						)
					)
				)
			)
		)
		(client setScript: 0)
	)
)
