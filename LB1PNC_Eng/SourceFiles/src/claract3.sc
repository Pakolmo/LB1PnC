;;; Sierra Script 1.0 - (do not remove this comment)
(script# 284)
(include game.sh)
(use Main)
(use atsgl)
(use Intrface)
(use System)

(public
	claract3 0
)

(local
	local0
	local1 = [284 0 284 0 284 1 284 1 284 2 284 3 284 4 284 5 284 6 284 7]
	local21 = [0 0 0 0 64 64 64 64 64 64 -1]
	local32 = [0 1 2 3]
	local36 =  4
	local37 = [5 6 7 8 9 10]
)
(instance claract3 of Script
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 284)
	)
	
	(method (handleEvent event &tmp temp0 temp1 i)
		(cond 
			((event claimed?))
			((and (== (event type?) saidEvent) global212)
				(= local0 -1)
				(= i [local32 (- global212 1)])
				(while (< i [local32 global212])
					(if
						(or
							(== global211 [local21 i])
							(== [local21 i] 0)
						)
						(= local0 i)
						(break)
					)
					(++ i)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(if (!= local0 local36)
						(global209 claimed: 1)
						(Print [local1 temp1] [local1 (++ temp1)])
					else
						(proc243_1 local0 [local1 temp1] [local1 (++ temp1)])
					)
				)
			)
		)
		(client setScript: 0)
	)
)
